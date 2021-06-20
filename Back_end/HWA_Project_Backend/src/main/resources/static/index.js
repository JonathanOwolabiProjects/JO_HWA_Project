'use strict';

const output = document.getElementById("output");

const getHouses = async () => {
    const res = await axios.get("/houses/");
    output.innerHTML = "";
    res.data.forEach(House => renderHouse(house));
}

const renderCar = ({ id, houseName, houseType, ownership, no.rooms, no.bathrooms, garden }) => {
    const column = document.createElement("div");
    column.className = "col";

    const card = document.createElement("div");
    card.className = "card";
    column.appendChild(card);

    const cardBody = document.createElement("div");
    cardBody.className = "card-body";
    card.appendChild(cardBody);

    const houseNameText = document.createElement("p");
    houseNameText.className = "card-text";
    houseNameText.innerText = `houseName: ${houseName}`;
    cardBody.appendChild(houseNameText);

    const houseTypeText = document.createElement("p");
    houseTypeText.className = "card-text";
    houseTypeText.innerText = `houseType: ${houseType}`;
    cardBody.appendChild(houseTypeText);

    const ownershipText = document.createElement("p");
    ownershipText.className = "card-text";
    ownershipText.innerText = `Ownership: ${ownership}`;
    cardBody.appendChild(ownershipText);

    const noRoomsText = document.createElement("p");
    noRoomsText.className = "card-text";
    noRoomsText.innerText = `noRooms: ${noRooms}`;
    cardBody.appendChild(noRoomsText);

    const noBathroomsText = document.createElement("p");
    noBathroomsText.className = "card-text";
    noBathroomsText.innerText = `noBathrooms: ${noBathrooms}`;
    cardBody.appendChild(noBathroomsText);

    const gardenText = document.createElement("p");
    gardenText.className = "card-text";
    gardenText.innerText = `Garden: ${garden}`;
    cardBody.appendChild(gardenText);

    const cardFooter = document.createElement("div");
    cardFooter.className = "card-footer";
    card.appendChild(cardFooter);

    const deleteButton = document.createElement("a");
    deleteButton.innerText = "Delete";
    deleteButton.className = "card-link";
    deleteButton.addEventListener("click", function () {
        deleteHouse(id);
    });
    cardFooter.appendChild(deleteButton);

    output.appendChild(column);
}

getHouses();

document.getElementById("createForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const data = {
        houseName: this.houseName.value,
        houseType: this.houseType.value,
        ownership: this.ownership.value,
        noRooms: this.noRooms.value,
        noBathrooms: this.noBathrooms.value,
        garden: this.garden.value
    }

    axios.post("/houses/create", data)
        .then(res => {
            getHouses();
            this.reset();
            this.make.focus();
        }).catch(err => console.log(err));

    console.log(this);
});

const deleteHouse = async (id) => {
    const res = await axios.delete(`/houses/remove/${id}`);
    getHouses();
};