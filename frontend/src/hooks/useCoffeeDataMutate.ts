import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios"
import { CoffeeData } from '../interface/CoffeeData';

const API_URL = 'http://localhost:8080';

const postData = async (data: CoffeeData): AxiosPromise<any> => {
    const response = axios.post(API_URL + '/coffee', data);
    return response;
}

export function useCoffeeDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries(['coffee-data'])
        }
    })

    return mutate;
}