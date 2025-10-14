
import java.util.Stack;

public class FolderDecode {

    public static void ReverseStack(Stack<String> s) {
        if (s.isEmpty()) {
            return;
        }
        String str = s.pop();
        ReverseStack(s);
        System.out.print(str + " ");
    }

    public static void FolderDecode(String arr[]) {
        Stack<String> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.equals("") || str.equals(".")) {
                continue;
            }

            if (str.equals("..")) {
                if (s.isEmpty()) {
                    continue;
                }
                s.pop();
            } else {
                String dummyStr = "/" + str;
                s.push(dummyStr);
            }
        }
        if (s.isEmpty()) {
            System.out.println("/");
        } else {
            ReverseStack(s);
        }

    }

    public static void main(String[] args) {
        String str = "/../a/b/../../";
        String arr[] = str.split("/");
        FolderDecode(arr);
    }
}
