public class className{
private String checkStatus(JsonBodyConsumer jb) throws IOException, JsonParseException {
		JsonFactory factory = new JsonFactory();
		JsonParser jp = factory.createJsonParser(jb.getContent());
		String status = "";

		while(!jp.isClosed()){
		    JsonToken jsonToken = jp.nextToken();
		
		    if(JsonToken.FIELD_NAME.equals(jsonToken)){
		    	String fieldName = jp.getCurrentName();
		        jsonToken = jp.nextToken();
		        if("status".equals(fieldName)) {
		        	status =  jp.getText();
		        } else if("message".equals(fieldName)) {
		        	logger.info("message is \""+ jp.getText() + "\"");
		        }
		    }
		}
		return status;
	}
  }
