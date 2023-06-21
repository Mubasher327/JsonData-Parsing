package com.DummyJson.demo.Service;
import com.DummyJson.demo.Entity.Products;
import com.DummyJson.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void addDummy() {

        try {
            // Step 1: Fetch JSON data from the API URL
            String apiUrl = "https://dummyjson.com/products";
            String jsonData = fetchJsonData(apiUrl);

            String[] responseParts = jsonData.split(",");

            for(String val :responseParts){
                System.out.println(val);
            }

            Products Dummy_Data = new Products();

            Dummy_Data.setId((responseParts[0].split(":")[1].trim()));
            Dummy_Data.setTitle(responseParts[1].split(":")[1].trim());
            Dummy_Data.setDescription(responseParts[2].split(":")[1].trim());
            Dummy_Data.setPrice((responseParts[3]).split(":")[1].trim());
            Dummy_Data.setDiscountPercentage(responseParts[4].split(":")[1].trim());
            Dummy_Data.setRating((responseParts[5]).split(":")[1].trim());
            Dummy_Data.setStock((responseParts[6]).split(":")[1].trim());
            Dummy_Data.setBrand(responseParts[7].split(":")[1].trim());
            Dummy_Data.setCategory(responseParts[8].split(":")[1].trim());

            String[] thumbnailsArray = responseParts[9].split(":")[1].replaceAll("\"", "").trim().split(",");;
            Dummy_Data.setThumbnail(Arrays.asList(thumbnailsArray));

            String[] imagesArray = responseParts[10].split(":")[1].replaceAll("\"", "").trim().split(",");;
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


