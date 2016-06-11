/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import br.produto.Produto;
import br.produto.ProdutoDAO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author pelusb
 */
public class Teste {

    public static void main(String[] args) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        try {

            PdfWriter writer = PdfWriter
                    .getInstance(
                            document,
                            new FileOutputStream(
                                    "C:\\Users\\Pedro Saraiva\\Desktop\\Codigo_Barra_iText.pdf"));

            document.open();

            ProdutoDAO pDAO = new ProdutoDAO();
            for (Produto p : pDAO.list()) {

                PdfContentByte cb = writer.getDirectContent();

                BarcodeEAN codeEAN = new BarcodeEAN();

                codeEAN.setCodeType(codeEAN.EAN13);

                codeEAN.setCode(p.getCodigo());

                Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);

                document.add(new Phrase(new Chunk(imageEAN, 0, 0)));
            }
        } catch (Exception de) {

            de.printStackTrace();

        }

        document.close();
    }
}
