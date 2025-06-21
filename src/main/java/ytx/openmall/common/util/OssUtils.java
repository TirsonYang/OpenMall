package ytx.openmall.common.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


public class OssUtils {

    @Value("${open.ali.oss.endpoint}")
    private static String endpoint;

    @Value("${open.aliyun.oss.accessKeyId}")
    private static String accessKeyId;

    @Value("${open.aliyun.oss.accessKeySecret}")
    private static String accessKeySecret;

    @Value("${open.aliyun.oss.bucketName}")
    private static String bucketName;

    public static String upload(MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();

        String originalFilename = multipartFile.getOriginalFilename();
        String fileName= UUID.randomUUID()+originalFilename;

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName,fileName,inputStream);

        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;

        ossClient.shutdown();

        return url;

    }


}
