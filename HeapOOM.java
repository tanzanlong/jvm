package spider.spider;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
   static class OOMObject{
	   
   }
   
   public static void main(String[] args) {
	 List<OOMObject> ooms=new ArrayList<OOMObject>();
	 while(true){
		 ooms.add(new OOMObject());
	 }
}
}
