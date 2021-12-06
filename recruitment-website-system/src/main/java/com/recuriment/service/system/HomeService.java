package com.recuriment.service.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recuriment.domain.pojo.system.CarouselInfo;
import com.recuriment.mapper.system.CarouselInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lqp
 * @Date 2021/11/6 17:21
 **/
@Service
public class HomeService {

    @Autowired
    CarouselInfoMapper carouselInfoMapper;

    public List<CarouselInfo> getCarouselList() {
        return carouselInfoMapper.selectList(new LambdaQueryWrapper<CarouselInfo>().eq(CarouselInfo::getIsDelete, 0));
    }

    /**
     * 添加公告
     * @param carouselInfo
     * @return
     */
    public int addCarousel(CarouselInfo carouselInfo) {
        return carouselInfoMapper.insert(carouselInfo);
    }

    /**
     * 更新公告
     * @param carouselInfo
     * @return
     */
    public int updateCarousel(CarouselInfo carouselInfo) {
        return carouselInfoMapper.updateById(carouselInfo);
    }

    /**
     * 删除公告
     * @return
     */
    public int deleteCarousel(Integer id) {
        CarouselInfo carouselInfo = new CarouselInfo().setId(id).setIsDelete(1);
        return carouselInfoMapper.updateById(carouselInfo);
    }
}
