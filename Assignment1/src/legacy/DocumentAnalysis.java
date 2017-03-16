package legacy;

public class DocumentAnalysis {
	private String[] arraySymbol = {"\\,","\\.","\\?","\\!","\\@","\\;","\\:","\\<","\\>",
				"\\$","\\#","\\%","\\&","\\*","\\(","\\)","\\+","\\-","\\=","\\[","\\]",
				"\\'","\\\"","\\\\","\\/","\\|"};
	
	public String documentWithoutSymbol(String document){
		String newstr = document;
		for (int i = 0; i < arraySymbol.length; i++){
			newstr = newstr.replaceAll(arraySymbol[i], " ");
		}
		System.out.println(newstr);
		String[] p = newstr.split(" ");
		return newstr;
	}
	
	public static void main(String[] args){
		DocumentAnalysis d = new DocumentAnalysis();
		d.documentWithoutSymbol("hi, you! are \\you someone?+you-you\"you\" 'o'");
	}
}
