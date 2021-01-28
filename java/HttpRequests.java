// Remove the irrelevant code

public class HttpRequests {

        public String performHttpGetOperation(){
          System.out.println("In fetchDataForTheInvestigationKey "  + investigationKey);
          CloseableHttpClient client = HttpClients.createDefault();
          CloseableHttpResponse response = null;
          HttpGet httpGet = new HttpRequestObject(client,investigationKey).getHttpGetRequest();
          try {
              response = client.execute(httpGet);
              System.out.println("----------------------------------------");
              System.out.println(response.getStatusLine().getStatusCode());
              String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
              System.out.println( responseBody);
              return responseBody;
          } catch (Exception ex){
             ex.printStackTrace();
          } finally {
              try {
                  if(!Objects.isNull(response))
                      response.close();
                  client.close();
              } catch (IOException e) {
                 e.printStackTrace();
              }
          }
          return "";
        }

        public HttpGet getHttpGetRequest(){
            HttpGet httpGet = null;
            try {
                System.out.println(getUrlWithInvestigationKey(url,investigationKey));
                httpGet = new HttpGet(getUrlWithInvestigationKey(url,investigationKey));
                UsernamePasswordCredentials creds
                        = new UsernamePasswordCredentials(user, password);
                httpGet.addHeader(new BasicScheme().authenticate(creds, httpGet, null));

                httpGet.setHeader("Accept", "application/json");
                httpGet.setHeader("Content-type", "application/json");
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
            return httpGet;
        }
        
        
        public String pergformHttpPostOperation(){
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = null;
                HttpPost httpPost = new HttpRequestObject(client,"").getHttpPostRequest(jsonRequest);
                try {
                    response = client.execute(httpPost);
                    return getKey(response);
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(!Objects.isNull(response))
                            response.close();
                        client.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                return "";
            }
        
        public HttpPost getHttpPostRequest(String jsonRequest){
            HttpPost httpPost = null;
            try {
                httpPost = new HttpPost(url);
                httpPost.setEntity(new StringEntity(jsonRequest));

                UsernamePasswordCredentials creds
                        = new UsernamePasswordCredentials(user, password);
                httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");

            } catch (AuthenticationException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return httpPost;
        }
}
