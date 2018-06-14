import {Injectable} from '@angular/core';
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private uri: string) {
  }

  getAllUser(): Promise<any> {
    return axios.request({
      baseURL: `${this.uri}`,
      headers: {Accept: "application/json"},
      method: "GET",
      url: "/billing/users",
    });
  }
}

interface AddressDTO {
  city: string
}

interface UserDTO {
  fullName: string,
  type: string,
  address: AddressDTO
}
