//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> res = new ArrayList<>();
        
        generate(0, S.toCharArray(),res);
        Collections.sort(res);
        return res;
    }
    public static void generate(int index, char []str , List<String> res){
        
        
        if(index == str.length-1){
            if(!res.contains(new String(str))){
            res.add(new String(str));}
            
            return;
        }
        
        for(int i=index; i<str.length; i++){
            swap(i,index, str);
            generate(index+1, str, res);
            swap(i, index, str);
        }
        
    }
    public static void swap(int i , int j , char []arr){
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}