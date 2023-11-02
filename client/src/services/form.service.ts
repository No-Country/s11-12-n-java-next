import fetchAPIService from "./api.service";

import { API_URL_FORM } from "@/config/urlConstant";

export async function getFormsService(data: FormSchema, token: string) {
  const res = await fetchAPIService(API_URL_FORM, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(data),
  });

  return res;
}

export async function createFormService(data: FormSchema, token: string) {
  const res = await fetchAPIService(API_URL_FORM, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(data),
  });

  return res;
}
