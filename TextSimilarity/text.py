import requests
import json

API_KEY = "RyPbcGEMl8PGSewbxwC5GijH"
SECRET_KEY = "6MvghO0k3h9RVCGBSLVxUK5sg4c5iYyo"




def getScore(text1, text2):
    url = "https://aip.baidubce.com/rpc/2.0/nlp/v2/simnet?charset=&access_token=" + get_access_token()

    headers = {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    }

    data = {}
    data["text_1"] = text1
    data["text_2"] = text2
    payload = json.dumps(data)

    response = requests.request("POST", url, headers=headers, data=payload)
    result = json.loads(response.text)
    return result["score"]


def get_access_token():
    """
    使用 AK，SK 生成鉴权签名（Access Token）
    :return: access_token，或是None(如果错误)
    """
    url = "https://aip.baidubce.com/oauth/2.0/token"
    params = {"grant_type": "client_credentials", "client_id": API_KEY, "client_secret": SECRET_KEY}
    return str(requests.post(url, params=params).json().get("access_token"))

