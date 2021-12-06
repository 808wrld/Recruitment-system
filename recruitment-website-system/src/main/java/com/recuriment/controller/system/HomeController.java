package com.recuriment.controller.system;

import com.recuriment.domain.pojo.system.CarouselInfo;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.service.system.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date
 **/
@RestController
@CrossOrigin
public class HomeController {

    @Autowired
    HomeService homeService;

    /**
     * 首页轮播
     * @return
     */
    @GetMapping("carousel")
    public PublicRes getCarouselInfo() {
        return PublicRes.OK(homeService.getCarouselList());
    }

    /**
     * 首页轮播
     * @return
     */
    @PostMapping("carousel")
    public PublicRes updateCarouselInfo(@RequestBody CarouselInfo carouselInfo) {
        return PublicRes.OK(homeService.updateCarousel(carouselInfo));
    }

    /**
     * 首页轮播
     * @return
     */
    @PutMapping("carousel")
    public PublicRes addCarouselInfo(@RequestBody CarouselInfo carouselInfo) {
        return PublicRes.OK(homeService.addCarousel(carouselInfo));
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("carousel/{id}")
    public PublicRes deleteCarousel(@PathVariable Integer id) {
        homeService.deleteCarousel(id);
        return PublicRes.OK();
    }

}
