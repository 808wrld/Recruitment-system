import {request} from "./request";

//添加项目经历（已实现，已链接到数据库）
export function addItemInfo(u_item) {
  return request({
    url: '/resume/add_item_info',
    method: 'post',
    data: u_item
  });
}

//更新项目经历信息（已实现，已链接到数据库）
export function updateItemInfo(u_item) {
  return request({
    url: '/resume/update_item_info',
    method: 'post',
    data: u_item
  })
}

//添加实习经历（已实现，已链接数据库）
export function addPracticeInfo(u_practice) {
  return request({
    url: '/resume/add_practice_info',
    method: 'post',
    data: u_practice
  })
}

//更新实习经历（已实现，已链接数据库）
export function updatePracticeInfo(u_practice) {
  return request({
    url: '/resume/update_practice_info',
    method: 'post',
    data: u_practice
  })
}

//获取简历信息（未实现，已连接数据库）
export function getUserResume() {
  return request({
    url: '/resume/get_user_resume',
    // method: 'get',
    // params: {
    //   u_id: u_id
    // }
  })
}

//获取指定id的用户实习经历信息（已实现，已连接数据库）
export function getUserPractice(u_id) {
  return request({
    url: '/resume/get_user_practice',
    method: 'get',
    params: {
      u_id: u_id
    }
  })
}

//获取指定id的用户项目经历信息（已实现，已连接数据库）
export function getUserItem(u_id) {
  return request({
    url: '/resume/get_user_item',
    method: 'get',
    params: {
      u_id: u_id
    }
  })
}

//获取简历投递状态和公司信息
export function getResumeAndCompanyInfo() {
  return request({
    url: '/resume',
    method: 'get'
  })
}

//投递简历
export function addResumeInfo(data) {
  return request({
    url: '/resume',
    method: 'post',
    data
  })
}

//根据u_id、j_id将状态值改为：已通过
export function updateStatePass(id) {
  return request({
    url: '/resume/pass/' + id,
    method: 'post'
  })
}

//根据u_id、j_id将状态值改为：已拒绝
export function updateStateReject(id) {
  return request({
    url: '/resume/reject/' + id,
    method: 'post'
  })
}

//根据u_id和j_id获取投递职位信息
export function getDeliverInfo(params) {
  return request({
    url: '/resume/info',
    method: 'get',
    params
  })
}

//按公司id和简历投递表获取用户和职位信息
export function getUserJob() {
  return request({
    url: '/resume/userCompanyJob',
    method: 'get'
  })
}
