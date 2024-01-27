"use client";

export default function ClientPage() {
  const sayHello = () => {
    alert("Hello Simmen!");
  };

  return (
    <>
      <button onClick={sayHello}>Hallo Simmen</button>
    </>
  );
}
