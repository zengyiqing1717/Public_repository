import request from '@/utils/request'

// 查询饮食记录列表
export function listDiet(query) {
  return request({
    url: '/diet/diet/list',
    method: 'get',
    params: query
  })
}

// 查询饮食记录详细
export function getDiet(id) {
  return request({
    url: '/diet/diet/' + id,
    method: 'get'
  })
}

// 新增饮食记录
export function addDiet(data) {
  return request({
    url: '/diet/diet',
    method: 'post',
    data: data
  })
}

// 修改饮食记录
export function updateDiet(data) {
  return request({
    url: '/diet/diet',
    method: 'put',
    data: data
  })
}

// 删除饮食记录
export function delDiet(id) {
  return request({
    url: '/diet/diet/' + id,
    method: 'delete'
  })
}
