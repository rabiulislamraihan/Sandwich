/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;


import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.DocumentProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.image.WritableImage;
import javafx.scene.transform.Scale;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import com.itextpdf.kernel.colors.ColorConstants;
import javax.imageio.ImageIO;

/**
 *
 * @author raiha
 */
public class PDFGenerator {

    public static void generatePdf(String text) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new ExtensionFilter("PDF files", "*.pdf"));

            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                String filePath = file.getAbsolutePath();

                PdfWriter pdfWriter = new PdfWriter(filePath);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                Document document = new Document(pdfDocument);

                Paragraph paragraph = new Paragraph(text);
                document.add(paragraph);

                document.close();
            }
        } catch (Exception e) {

        }
    }
    
    
    

    public static void generatePdf(PieChart piechart) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF");
            fileChooser.getExtensionFilters().add(new ExtensionFilter("PDF files", "*.pdf"));

            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                String filePath = file.getAbsolutePath();

                PdfWriter pdfWriter = new PdfWriter(filePath);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                Document document = new Document(pdfDocument);


                Rectangle chartRect = new Rectangle(1000, 400);
                BufferedImage chartImage = PDFGenerator.convertNodeToImage(piechart, chartRect, true);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(chartImage, "png", baos);
                Image iTextImage = new Image(ImageDataFactory.create(baos.toByteArray()));

                Paragraph imageParagraph = new Paragraph().setBackgroundColor(new DeviceRgb(200, 200, 200));
                imageParagraph.add(iTextImage);

                document.add(imageParagraph);

                document.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("PieChart has been Downloaded Successfully.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error generating PDF: " + e.getMessage());
            alert.showAndWait();
        }

    }

    
    
    public static BufferedImage convertNodeToImage(Node node, Rectangle bounds, boolean preserveRatio) {
        SnapshotParameters parameters = new SnapshotParameters();

        double width = bounds.getWidth();
        double height = bounds.getHeight();

        if (preserveRatio) {
            double nodeRatio = node.getLayoutBounds().getWidth() / node.getLayoutBounds().getHeight();
            if (width / height > nodeRatio) {
                width = height * nodeRatio;
            } else {
                height = width / nodeRatio;
            }
        }

        parameters.setTransform(new Scale(width / node.getLayoutBounds().getWidth(), height / node.getLayoutBounds().getHeight()));

        WritableImage snapshot = node.snapshot(parameters, null);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(snapshot, null);

        return bufferedImage;
    }


}

    
