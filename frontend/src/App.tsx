import { useState } from 'react'
import './App.css'
import { Card } from './components/card/card';
import { CoffeeData } from './interface/CoffeeData';
import { useCoffeeData } from './hooks/useCoffeeData';
import { CreateModal } from './components/create-modal/create-modal';

function App() {
  const { data } = useCoffeeData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev)
  }

  return (
    <div className="container">
      <h1>Cardápio</h1>
      <div className="card-grid">
        {data?.map(coffeeData => 
          <Card
            price={coffeeData.price} 
            title={coffeeData.title} 
            image={coffeeData.image}
          />
        )}
      </div>
      {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
      <button onClick={handleOpenModal}>novo</button>
    </div>
  )
}

export default App