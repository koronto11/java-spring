//获得ajax对象 
function getXhr(){
    	  var xhr=null;
    	  if(window.XMLHttpRequest){
    		  //非ie浏览器
    		  xhr=new XMLHttpRequest();
    	  }else{
    		  //ie浏览器
    		  xhr=new ActiveXObject(
    				  "Microsoft.XMLHttp");
    	  }
    	  return xhr;
      }

//依据id查找某个节点的值

function $(id){
	return document.getElementById(id);
	
}

//这样用户输入某个id就可以返回对应id节点的值
//依据id查找节点并返回节点的value
function $F(id){
	return $(id).value;
	
}