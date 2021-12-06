import {request} from "./request";



//获取工作信息
export function getJobData(params) {
  return request({
    url: '/job/',
    params
  });
}

// 根据公司id获取职位信息（已实现，已连接数据库）
export function getJobInfoByCId(id) {
  return request({
    url: '/job/byCid/' + id,
    method: 'get'
  })
}

//根据id获取职位信息（用于修改职位信息）
export function getJobInfoByJId(jId) {
  return request({
    url: '/job/byJid/' + jId,
    method: 'get'
  })
}

//按id删除职位信息（已实现，已连接数据库）
export function deleteJobInfo(jId) {
  return request({
    url: '/job/' + jId,
    method: 'delete'
  })
}


//添加工作
export function addJob(data) {
  return request({
    url: '/job/addJob',
    method: 'put',
    data
  })
}

//修改工作信息
export function modifyJobInfo(data) {
  return request({
    url: '/job',
    method: 'post',
    data
  })
}
