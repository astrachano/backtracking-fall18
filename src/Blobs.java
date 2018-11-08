	

/**
 * @author ola
 */
public class Blobs {
	public static void main(String[] args){
		 BlobViewer bv = new BlobViewer("Duke BlobCount");
		 BlobModel model = new IterativeBlobModel();
		 bv.setModel(model);
	}
}
