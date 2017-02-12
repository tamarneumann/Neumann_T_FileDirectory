//Tamar Neumann
import java.io.File;


public class Directory {
public static void main(String[]args){
		
		
		int quantity=1; //the amount of indentations. Begin with 1 after the first folder is displayed.
	    File largest=null;
		try{
	
		File directory=new File("C:\\Users\\tamar\\Documents");
		
		System.out.println(directory.getName()+"\n");
		largest=addFile( directory,quantity,largest);
		
		System.out.println("The largest file in the directory is "+largest.getName()
		                  +".\nIts path is "+largest.getPath()
		                  +".\nIts size is "+largest.length()+" bytes");
		
        }
      catch(NullPointerException e)
      {
    	  System.out.println("No directory found");
      }
	}

/**
 * Recursive method to display all folders and subfolders of a directory.
 * @param directory The current folder or file.
 * @param quantity The amount of indentations required to display directory based on the number
 *        of recursive calls.
 * @return The biggest file in the directory.
 */
	public static File addFile(File directory, int quantity, File largest){

		
		
		for(File file:directory.listFiles())
		{			
			if(file.isDirectory())
			{
				//display the correct indentations and then display the folder name.
				display(quantity);
				System.out.println("Folder: "+file.getName()+"\n");
				
				//with each new folder, increase the quantity of indentations.
				quantity++;
				
				largest=addFile(file,quantity,largest);
				//after the folder is completely displayed, decrease the quantity of indentations.
				quantity--;
			}
			else
			{
				//assign the first file to the largest variable.
				if(largest==null)
					largest=file;
				
				//if the current file is larger than the largest file, than assign it to the largest variable.
				else if(file.length()>largest.length())
					largest=file;
				
				//display the correct indentations and then display the file name and size.
				display(quantity);
				System.out.println("File: "+file.getName()+"    size:"+file.length()+" bytes"+"\n");
			}
				
		}
		
		return largest;
	}
	   
	/**
	 * Recursive method that displays indentations as needed to display the directory.
	 * @param quantity The number of indentations needed.
	 */
    public static void display(int quantity){
       
    	if (quantity ==0 ){
    		System.out.print("->");
            return ;
        }
    
        System.out.print("\t");
        display( quantity-1);
       
        
        
    }
}
