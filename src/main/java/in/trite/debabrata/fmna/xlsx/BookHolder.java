package in.trite.debabrata.fmna.xlsx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BookHolder {
    Workbook workbook;
    String name;

    public void addSheet(String name, String[][] content) {
        Sheet sheet = workbook.createSheet(name);

        for (int r = 0; r < content.length; r++) {
            Row row = sheet.createRow(r);
            for (int c = 0; c < content[r].length; c++) {
                Cell cell = row.createCell(c);
                cell.setCellValue(content[r][c]);
            }
        }
    }

    public void writeToPath(Path path) throws IOException {
        path = path.resolve(name+".xlsx");

        try (OutputStream file = Files.newOutputStream(path)) {
            workbook.write(file);
        }

        workbook.close();
    }

    public BookHolder(String name) {
        this.workbook = new XSSFWorkbook();
        this.name = name;
    }
}
