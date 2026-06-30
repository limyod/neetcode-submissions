class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        //add values into token until we see a operator
        for(String token: tokens){
            if(token.equals("+")){
                int n2 = s.pop();
                int n1 = s.pop();
                s.push(n1 + n2);
            }else if(token.equals("-")){
                int n2 = s.pop();
                int n1 = s.pop();
                s.push(n1 - n2);
            }else if(token.equals("/")){
                int n2 = s.pop();
                int n1 = s.pop();
                s.push(n1 / n2);
            }else if(token.equals("*")){
                int n2 = s.pop();
                int n1 = s.pop();
                s.push(n1 * n2);
            }else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
