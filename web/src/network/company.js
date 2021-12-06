import {request} from "./request";

//获取公司信息
export function getCompany() {
  return request({
    url: '/company'
  });
}

//公司详情
export function getCompanyById(id) {
  return request({
    url: '/company/info/' + id,
    method: 'get',
  })
}

//获取公司详细信息
export function getCompanyInfo() {
  return request({
    url: '/company/info'
  })
}

//获取企业用户归属公司id
export function getUserCompanyInfo() {
  return request({
    url: '/company/userCompany',
    method: 'get',
  })
}

//注册公司，添加公司(已实现，已联通数据库)
export function addCompanyInfo(data) {
  return request({
    url: '/company/userCompany',
    method: 'put',
    data
  })
}

//更新公司详细信息(已实现)
export function updateCompanyInfo(data) {
  return request({
    url: '/company/userCompany',
    method: 'post',
    data
  })
}

//查询公司账号和详细信息(已实现)
export function getCompanyEI() {
  return request({
    url: '/company/get_company_EI'
  })
}

//强制删除公司账号和信息(已实现)
export function deleteCompanyEI(c_id) {
  return request({
    url: '/company/delete_company_EI',
    method: 'get',
    params: {
      c_id: c_id
    }
  })
}

//修改密码
export function updateCompanyPassword(c_id,c_password) {
  return request({
    url: '/company/update_company_password',
    method: 'post',
    data: {
      c_id: c_id,
      c_password: c_password
    }
  })
}