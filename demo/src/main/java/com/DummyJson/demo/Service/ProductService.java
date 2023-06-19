package com.DummyJson.demo.Service;
import com.DummyJson.demo.Entity.Products;
import com.DummyJson.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

        public void addDummy() {

                try {
                    // Step 1: Fetch JSON data from the API URL
                    String apiUrl = "https://dummyjson.com/products/1";
                    String jsonData = fetchJsonData(apiUrl);

                    String[] responseParts = jsonData.split(",");
                    for(String val :responseParts){
                        System.out.println(val);
                    }

                    Products Dummy_Data = new Products();

                    Dummy_Data.setId(Long.parseLong(responseParts[0]));
                    Dummy_Data.setTitle(responseParts[1]);
                    Dummy_Data.setDescription(responseParts[2]);
                    Dummy_Data.setPrice(new BigDecimal(responseParts[3]));
                    Dummy_Data.setRating(new BigDecimal(responseParts[4]));
                    Dummy_Data.setStock(Integer.parseInt(responseParts[5]));
                    Dummy_Data.setBrand(responseParts[6]);
                    Dummy_Data.setCategory(responseParts[7]);

                    String[] thumbnailsArray = responseParts[8].split(":");
                    Dummy_Data.setThumbnail(Arrays.asList(thumbnailsArray));

                    String[] imagesArray = responseParts[9].split(":");
                    Dummy_Data.setImages(Arrays.asList(imagesArray));

                   productRepo.save(Dummy_Data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private String fetchJsonData(String apiUrl) throws IOException {
                StringBuilder jsonData = new StringBuilder();
                URL url = new URL(apiUrl);
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    jsonData.append(line);
                }

                reader.close();
                return jsonData.toString();
            }
    }


