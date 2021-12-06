import {request} from "./request";

//获取用户信息（账号密码，id）
export function getUser() {
  return request({
    url: '/users/'
  });
}

//根据id获取用户账号密码
export function getUserById(u_id) {
  return request({
    url: '/users/get_user_by_uid',
    method: 'get',
    params: {
      u_id: u_id
    }
  })
}

//获取用户详细信息
export function getUserInfo() {
  return request({
    url: '/user/info'
  });
}

//用户个人信息
export function getUserDetailInfoById() {
  return request({
    url: '/user/detail',
    method: 'get'
  })
}

//登录
export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    data
  })
}

//添加用户（注册）
export function addUser(data) {
  return request({
    url: '/register',
    method: 'post',
    data
  })
}

//添加用户信息 personal Center（已实现，已连接到数据库）
export function addUserInfo(data) {
  return request({
    url: '/user/detail',
    method: 'put',
    data
  })
}

//更新用户信息（已实现，已连接到数据库）
export function updateUserInfo(data) {
  return request({
    url: '/user/detail',
    method: 'post',
    data
  })
}

//查询求职用户信息
export function getUserByJober() {
  return request({
    url: '/user/byJober'
  })
}

//查询企业用户信息
export function getUserByCompanyManager() {
  return request({
    url: '/user/byCompany'
  })
}

//强制注销/删除用户账号和信息（已实现，已连接到数据库）
export function deleteUser(id) {
  return request({
    url: '/user/' + id,
    method: 'delete'
  })
}

//修改密码
export function updateUserPassword(data) {
  return request({
    url: '/user/changePassword',
    method: 'post',
    data
  })
}


//获取文档列表
export function getUserFile() {
  return request({
    url: '/userFile',
    method: 'get',
  })
}


//添加文档
export function addUserFile(data) {
  return request({
    url: '/userFile',
    method: 'put',
    data
  })
}


//删除文档
export function deleteUserFile(id) {
  return request({
    url: '/userFile/' + id,
    method: 'delete'
  })
}

/*
* 添加投诉
*/
export function addComplain(data) {
  return request({
    url: '/userComplain',
    method: 'put',
    data
  })
}

// 获取用户投诉列表
export function getComplain() {
  return request({
    url: '/userComplain',
    method: 'get'
  })
}

//删除用户投诉
export function deleteComplain(id) {
  return request({
    url: '/userComplain/' + id,
    method: 'delete'
  })
}

