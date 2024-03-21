package br.com.DarthVader.servlet.Produto;

import br.com.DarthVader.dao.ProdutoDAO;
import br.com.DarthVader.modal.Produto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

@WebServlet("/cadastrar-produto")
public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> parameters= uploadImage(req);


        String prodIMG=parameters.get("image1");
        String prodIMG2=parameters.get("image2");
        String prodIMG3=parameters.get("image3");
        String prodIMG4=parameters.get("image4");

        String prodNome=parameters.get("Prod-Nome");
            if(prodNome==null){prodNome=parameters.get("Prod-Nome-Alt");
                prodIMG=parameters.get("image-Alt");
                prodIMG2=parameters.get("image2-Alt");
                prodIMG3=parameters.get("image3-Alt");
                prodIMG4=parameters.get("image4-Alt");}

        String avaliacao=parameters.get("Prod-Avaliacao");
            if(avaliacao==null){avaliacao=parameters.get("Prod-Avaliacao-Alt");}

        String prodDescricao=parameters.get("Prod-Descricao");
            if(prodDescricao==null){prodDescricao=parameters.get("Prod-Descricao-Alt");}

        String preco=parameters.get("Prod-Preco");
            if(preco==null){preco=parameters.get("Prod-Preco-Alt");}

        String estoque=parameters.get("Prod-Quantidade");
            if(estoque==null){estoque=parameters.get("Prod-Quantidade-Alt");}

        String prodID=parameters.get("id");
            if(prodID==null){prodID=parameters.get("id-Alt");}



        double prodPreco = Double.parseDouble(preco.replace(",", "."));
        int prodEstoque = Integer.parseInt(estoque);
        int prodAvaliacao = Integer.parseInt(avaliacao);


        Produto produto = new Produto(prodID, prodNome, prodAvaliacao, prodDescricao, prodPreco, prodEstoque, prodIMG, prodIMG2, prodIMG3, prodIMG4);
        System.out.println(produto.getId());

        ProdutoDAO produtoDAO = new ProdutoDAO();
        if (prodID.isEmpty()){
            produtoDAO.cadastroProduto(produto);
        }else{
            produtoDAO.alterarProduto(produto);
        }

        resp.sendRedirect("/achar-todos-produtos");
    }

    private Map<String, String> uploadImage(HttpServletRequest request){

        HashMap<String, String> parameters = new HashMap<>();

        if(isMultipartContent(request)){

            try {
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                List<FileItem> arquivos = new ServletFileUpload(diskFileItemFactory).parseRequest(request);

                for(FileItem arquivo : arquivos){

                    checkFieldType(arquivo, parameters);

                }

            }catch (Exception e){
                parameters.put("image","img/default-item.jpg");
            }

            return parameters;

        }

        return parameters;

    }

    private int imageNumber = 0;

    private void checkFieldType(FileItem arquivo, Map requestParameters) throws Exception {
        if(arquivo.isFormField()){
            requestParameters.put(arquivo.getFieldName(), arquivo.getString());
        } else {
            imageNumber++;
            String nomeArquivo = UploadFile(arquivo);
            requestParameters.put(String.valueOf("image" + imageNumber),nomeArquivo);
        }
    }

    private String UploadFile(FileItem arquivo) throws Exception {

         Long horarioAtual = new Date().getTime();

         String nomeArquivo = horarioAtual.toString().concat("-").concat(arquivo.getName().replace(" ", ""));
         String caminhoArquivo = this.getServletContext().getRealPath("img").concat(File.separator).concat(nomeArquivo);
         arquivo.write(new File(caminhoArquivo));

        return nomeArquivo;
    }


}
