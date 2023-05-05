import { useEffect, useState } from 'react';
import { useCoffeeDataMutate } from '../../hooks/useCoffeeDataMutate';
import { CoffeeData } from '../../interface/CoffeeData';

import "./modal.css";

interface InputProps {
    label: string,
    value: string | number,
    updateValue(value: any): void
}   

interface ModalProps {
    closeModal(): void
}

const Input = ({ label, value, updateValue }: InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input value={value} onChange={event => updateValue(event.target.value)}></input>
        </>
    )
}

export function CreateModal({ closeModal }: ModalProps){
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState(0);
    const [image, setImage] = useState("");
    const { mutate, isSuccess, isLoading } = useCoffeeDataMutate();

    const submit = () => {
        const coffeeData: CoffeeData = {
            title, 
            price,
            image
        }
        mutate(coffeeData)
    }

    useEffect(() => {
        if(!isSuccess) return 
        closeModal();
    }, [isSuccess])

    return(
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>Cadastre um novo item no cardápio</h2>
                <form className="input-container">
                    <Input label="Título: " value={title} updateValue={setTitle}/>
                    <Input label="Preço: " value={price} updateValue={setPrice}/>
                    <Input label="URL da imagem: " value={image} updateValue={setImage}/>
                </form>
                <button onClick={submit} className="btn-secondary">
                    {isLoading ? 'postando...' : 'postar'}
                </button>
            </div>
        </div>
    )
}