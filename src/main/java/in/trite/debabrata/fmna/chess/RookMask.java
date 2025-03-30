package in.trite.debabrata.fmna.chess;

public class RookMask {
    public static long get(int index) {
        long fileH = 0x0101010101010101L;
        long rank0 = 0x00000000000000FFL;
        long fileHWithoutEdges = 0x0001010101010100L;
        long rank0WithoutEdges = 0x000000000000007EL;
        long border = 0xFF818181818181FFL;
        int file = index % 8;
        int rank = index / 8;

        long mask = ((fileH << file ) ^ (rank0 << (rank * 8)));

        mask = mask & (~ border);
        if ( file == 0 || file == 7 ) {
            mask = mask | (fileHWithoutEdges << file);
        }
        if ( rank == 0 || rank == 7 ) {
            mask = mask | (rank0WithoutEdges << (rank * 8));
        }
        mask = mask & ~ (1L << index);
        return mask;
    }
}
