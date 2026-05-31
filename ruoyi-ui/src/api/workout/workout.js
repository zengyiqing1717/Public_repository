import request from '@/utils/request'

// 查询运动打卡记录列表
export function listWorkout(query) {
  return request({
    url: '/system/record/list',   // 修改点
    method: 'get',
    params: query
  })
}

// 查询运动打卡记录详细
export function getWorkout(id) {
  return request({
    url: '/system/record/' + id,   // 修改点
    method: 'get'
  })
}

// 新增运动打卡记录
export function addWorkout(data) {
  return request({
    url: '/system/record',   // 修改点
    method: 'post',
    data: data
  })
}

// 修改运动打卡记录
export function updateWorkout(data) {
  return request({
    url: '/system/record',   // 修改点
    method: 'put',
    data: data
  })
}

// 删除运动打卡记录
export function delWorkout(id) {
  return request({
    url: '/system/record/' + id,   // 修改点
    method: 'delete'
  })
}