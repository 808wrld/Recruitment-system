import {request} from "./request";

export function getJobByJId(jId) {
  return request({
    url: '/job/info/' + jId,
    method: 'get'
  })
}