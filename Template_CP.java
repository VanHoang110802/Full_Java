import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputReader _ir = new InputReader(System.in);
        PrintWriter _pw = new PrintWriter(System.out);

        TaskSolve tSol = new TaskSolve();
        tSol.solveHere(1, _ir, _pw);

        _pw.close();
    }

    static class InputReader {
        BufferedReader _reader;
        StringTokenizer _tokenizer;

        public InputReader(InputStream _is) {
            _reader = new BufferedReader(new InputStreamReader(_is));
            _tokenizer = null;
        }

        String next() {
            while(_tokenizer == null || !_tokenizer.hasMoreElements()){
                try {
                    _tokenizer = new StringTokenizer(_reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return _tokenizer.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            try {
                return _reader.readLine();
            } catch(IOException e){
                throw new RuntimeException(e);
            }

        }
    }

    static class TaskSolve {

        public void solveHere(int testNumber, InputReader inp, PrintWriter out) {

        }
    }
}
