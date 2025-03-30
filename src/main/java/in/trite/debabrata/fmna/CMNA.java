package in.trite.debabrata.fmna;

import in.trite.debabrata.fmna.chess.RookMask;
import in.trite.debabrata.fmna.xlsx.BookHolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// CHESS MAGIC NUMBER ANALYSER.
public class CMNA {
    public static void main(String[] args) throws IOException {
        var book = new BookHolder("cmna");

        for (int i = 0; i < 64; i++) {
            // For each square in a chess board.
            var mask = RookMask.get(i);
            var content = content(mask);
            book.addSheet(Integer.toString(i), content);
        }

        var path = getPath(args);
        book.writeToPath(path);

        System.out.println("Written to: " + path);
    }

    private static String[][] content(long x) {
        String [][] result = new String[Long.bitCount(x)][];

        // Finding all place values of x with zero.
        boolean[] marker = new boolean[64];
        for (long i = 1, j = 0; i != 0; i <<= 1, j++) {
            if ((i & x) != 0) {
                marker[(int) j] = true;
            }
        }

        // Looping over all place values of X.
        int bc = 0; // Right-buffer counter.
        int lc = 0; // Line counter.
        for (int i = 0; i < 64; i++) {
            bc++;
            if (!marker[i]) {
                continue;
            }
            String [] line = new String[64];

            // Looping for all indexes of the magic number.
            for (int j = 63 - bc, m = 0; j >= 0; j--, m++) {
                // Appending the multipliers in reverse.
                line[j] = "m" + m + "x" + i;
            }
            result[lc++] = line;
        }
        return result;
    }

    /**
     * @param args Takes in command line argument. Checks if there's a valid dir at path.
     * @return Returns directory from args as path, otherwise returns user directory.
     */
    private static Path getPath(String[] args) {
        if (args.length > 0) {
            Path path = Path.of(args[0]);
            if (Files.exists(path) && Files.isDirectory(path)) {
                return path;
            }
        }
        return Path.of(System.getProperty("user.dir"));
    }
}
