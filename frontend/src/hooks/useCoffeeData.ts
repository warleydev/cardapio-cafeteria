import { useQuery } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios"
import { CoffeeData } from '../interface/CoffeeData';

const API_URL = 'http://localhost:8080';

const fetchData = async (): AxiosPromise<CoffeeData[]> => {
    const response = axios.get(API_URL + '/coffee');
    return response;
}

export function useCoffeeData(){
    const query = useQuery({
        queryFn: fetchData,
        queryKey: ['coffee-data'],
        retry: 2
    })

    return {
        ...query,
        data: query.data?.data
    }
}