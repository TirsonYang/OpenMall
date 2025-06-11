package ytx.openmall.server.controller.seller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ytx.openmall.pojo.DTO.SellerRegisterDTO;
import ytx.openmall.server.service.RegisterService;


@Slf4j
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/seller/register")
    String sellerRegister(SellerRegisterDTO SellerRegisterDTO){
        return null;
    }

}
