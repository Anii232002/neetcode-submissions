class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i= 0;i< s.length(); i++)
        {
            char c = s.charAt(i);
            if(isOpen(c))
            {
                stk.push(c);
            }
            else{
                if(stk.size()==0)return false;
                char pop = stk.pop();
                if(!matches(c,pop))return false;
            }

        }
        return stk.size()==0;
    }

    public boolean isOpen(char c)
    {
        return (c=='(' | c=='{' || c=='[');
    }

    public boolean matches(char a,char b)
    {
        switch(a)
        {
            case ']': 
                return b=='[';
            case '}' :
                return b=='{';
            case ')':
                return b=='(';
            
        }

        return true;

    }
}
