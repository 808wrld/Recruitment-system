import {request} from "./request";



//获取首页轮播
export function getCarousel(params) {
  return request({
    url: '/carousel',
    params
  });
}
// 更新首页轮播
export function updateCarousel(data) {
  return request({
    url: '/carousel',
    method: 'post',
    data
  })
}

// 添加首页轮播
export function addCarousel(data) {
  return request({
    url: '/carousel',
    method: 'put',
    data
  })
}

// 删除首页轮播
export function deleteCarousel(id) {
  return request({
    url: '/carousel/' + id,
    method: 'delete'
  })
}