package algo;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 功能描述: 利用栈结构 检查js代码格式是否正确
 * @author: qinxuewu
 * @date: 2019/10/24 14:59
 * @since 1.0.0
 */
public class StackScript {

    public static void main(String[] args) {
        Stack<String> st=new Stack<String>();
        String value="(var x={y:[1,2,3]})";
        Map<String,String> map=new HashMap<String, String>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        /**
         * 思路： 1 首先遇左边的符号就入栈 遇到右边的符号就把当前栈出债和左符号比较
         */
        for (int i = 0; i < value.length(); i++) {
            char ch=value.charAt(i);
            //  过滤符号意外的参数
            if(ch=='(' || ch=='{' || ch=='[' || ch==')' || ch=='}' || ch==']'){
                String s=String.valueOf(ch);
                System.err.println(ch);
                // 如果是右括号 则入栈
                if(map.containsKey(s)){
                    st.push(s);
                }else if(ch==')' || ch=='}' || ch==']'){
                    // 左括号 查看栈顶元素进行判断
                    if(st.isEmpty()) {
                        System.err.println("栈里没任何元素 ，2类语法错误");
                        break;
                    }
                    String a=st.peek();
                    // 如果栈顶元素是匹配的 ,则弹出栈
                    if(map.get(a).toString().equals(s)){
                        st.pop();
                    }else{
                        System.err.println("符号不匹配 结束循环");
                        return;
                    }
                }
            }
        }
    }
}
