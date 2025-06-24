package ytx.openmall.common.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Component
public class OssUtils {

    @Value("${open.ali.oss.endpoint}")
    private String endpoint;

    @Value("${open.aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${open.aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${open.aliyun.oss.bucketName}")
    private String bucketName;

    public  String upload(MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();

        String originalFilename = multipartFile.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName= UUID.randomUUID()+extension;

        System.out.println("accessKeyId"+accessKeyId);
        System.out.println("accessKeySecret"+accessKeySecret);
        System.out.println("bucketName"+bucketName);
        System.out.println("endpoint"+endpoint);

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName,fileName,inputStream);

        //文件访问路径规则 https://BucketName.Endpoint/ObjectName
        String url = new StringBuilder("https://").append(bucketName).append(".").append(endpoint).append("/").append(fileName).toString();

        ossClient.shutdown();

        return url;

    }


}
