import fetchAPIService from "./api.service";

import { API_URL_FORM } from "@/config/urlConstant"

export async function getFormsService(data: FormSchema) {
  const res = await fetchAPIService(API_URL_FORM, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huZG9lQG1haWwuY29tIiwiaWF0IjoxNjk4ODAyMzM3LCJleHAiOjE2OTg4MzgzMzd9.qUu-_Sh55UzczaSAEQ_u4-ut0M63QqWkVUXxfheq0qk"
    },
    body: JSON.stringify(data)
  })

  return res
}

export async function createFormService(data: FormSchema) {
  const res = await fetchAPIService(API_URL_FORM, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huZG9lQG1haWwuY29tIiwiaWF0IjoxNjk4ODAyMzM3LCJleHAiOjE2OTg4MzgzMzd9.qUu-_Sh55UzczaSAEQ_u4-ut0M63QqWkVUXxfheq0qk"
    },
    body: JSON.stringify(data),
  })

  return res
}