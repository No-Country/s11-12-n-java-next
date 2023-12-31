const fetchAPIService = async (
  url: string,
  options?: RequestOptions
): Promise<ApiResponse> => {
  try {
    const method = options?.method || "GET";
    const res = await fetch(url, { ...options, method });
    console.log(res.body);
    const data = !res.body ? undefined : await res.json();

    return { resolved: true, payload: data };
  } catch (error) {
    const payload = error instanceof Error ? error.message : "apierror";
    return { resolved: false, payload };
  }
};

export default fetchAPIService;
