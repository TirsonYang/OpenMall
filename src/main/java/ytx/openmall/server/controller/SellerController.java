package ytx.openmall.server.controller;

import io.netty.util.ResourceLeakDetector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ytx.openmall.common.constant.LoginConstant;
import ytx.openmall.common.constant.RegisterConstant;
import ytx.openmall.common.exception.BaseException;
import ytx.openmall.common.result.Result;
import ytx.openmall.pojo.DTO.SellerLoginDTO;
import ytx.openmall.pojo.DTO.SellerRegisterDTO;
import ytx.openmall.pojo.DTO.SellerUpdatePasswordDTO;
import ytx.openmall.pojo.VO.SellerLoginVO;
import ytx.openmall.pojo.entity.Seller;
import ytx.openmall.server.service.SellerService;


@Slf4j
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    /**
     * 商家注册
     * @param sellerRegisterDTO
     * @return
     */
    @PostMapping("/register")
    Result sellerRegister(@RequestBody SellerRegisterDTO sellerRegisterDTO){
        log.info("收到请求");
        //注册时用户名和密码不能为空
        if (sellerRegisterDTO.getUsername()==null&&sellerRegisterDTO.getPassword()==null){
            return Result.error(RegisterConstant.NOT_CAN_BE_NULL);
        }
        log.info("username:{},password:{}",sellerRegisterDTO.getUsername(),sellerRegisterDTO.getPassword());
        Seller seller=new Seller();
        BeanUtils.copyProperties(sellerRegisterDTO,seller);
        //属性拷贝
        sellerService.insert(seller);
        return Result.success();
    }

    @PostMapping("/login")
    Result<SellerLoginVO> sellerLogin(@RequestBody SellerLoginDTO sellerLoginDTO){
        log.info("商家登录");
        if (sellerLoginDTO.getUsername()==null){
            return Result.error(LoginConstant.USERNAME_IS_NULL);
        }
        if (sellerLoginDTO.getPassword()==null){
            return Result.error(LoginConstant.PASSWORD_IS_NULL);
        }
        log.info("username:{},password:{}",sellerLoginDTO.getUsername(),sellerLoginDTO.getPassword());
        SellerLoginVO sellerLoginVO=sellerService.login(sellerLoginDTO);
        if (sellerLoginVO==null){
            return Result.error(LoginConstant.USERNAME_PASSWORD_IS_FALSE);
        }


        return Result.success(sellerLoginVO);
    }


    @PostMapping("/password")
    Result sellerUpdatePassword(@RequestBody SellerUpdatePasswordDTO sellerUpdatePasswordDTO){
        log.info("修改密码");
        if (sellerUpdatePasswordDTO==null){
            throw new BaseException("传参不能为空");
        }

        int flag=sellerService.updatePassword(sellerUpdatePasswordDTO);

        if (flag==1){
            return Result.error("用户不存在");
        } else if (flag==2) {
            return Result.error("密码错误");
        }

        return Result.success();
    }



}
