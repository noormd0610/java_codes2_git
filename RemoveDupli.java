
public class RemoveDupli {

    public static StringBuilder RemoveDupli(String string, StringBuilder newStr, boolean arr[], int i) {

        //1.base
        if (string.length() == i) {
            return newStr;
        }

        //2.kaam
        char currChar = string.charAt(i);
        if (arr[currChar - 'a'] == false) {
            arr[currChar - 'a'] = true;
            newStr.append(currChar);
        }
        return RemoveDupli(string, newStr, arr, i + 1);
    }

    public static void main(String[] args) {
        String string = "appnnacollege";
        boolean arr[] = new boolean[26];
        System.out.println(RemoveDupli(string,new StringBuilder(""), arr, 0));

    }
}
