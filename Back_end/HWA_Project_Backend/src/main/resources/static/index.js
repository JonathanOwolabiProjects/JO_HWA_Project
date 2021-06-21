'use strict';
// house functionality
const output = document.getElementById("output");

const getHouses = async () => {
    const res = await axios.get("/houses/");
    const output = document.getElementById("houseCards")
    output.innerHTML = "";
    res.data.forEach(house => renderHouse(house));
}

const renderHouse = ({ id, houseName, houseType, ownership, noRooms, noBathrooms, garden }) => {
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
    houseNameText.innerText = `House Name: ${houseName}`;
    cardBody.appendChild(houseNameText);

    const houseTypeText = document.createElement("p");
    houseTypeText.className = "card-text";
    houseTypeText.innerText = `House Type: ${houseType}`;
    cardBody.appendChild(houseTypeText);

    const ownershipText = document.createElement("p");
    ownershipText.className = "card-text";
    ownershipText.innerText = `Ownership: ${ownership}`;
    cardBody.appendChild(ownershipText);

    const noRoomsText = document.createElement("p");
    noRoomsText.className = "card-text";
    noRoomsText.innerText = `Number of Rooms: ${noRooms}`;
    cardBody.appendChild(noRoomsText);

    const noBathroomsText = document.createElement("p");
    noBathroomsText.className = "card-text";
    noBathroomsText.innerText = `Number of Bathrooms: ${noBathrooms}`;
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
            this.houseName.focus();
        }).catch(err => console.log(err));

    console.log(this);

    axios.put("/houses/update", data)
        .then(res => {
            getHouses();
            this.reset();
            this.houseName.focus();
        }).catch(err => console.log(err));

    console.log(this);
});

const deleteHouse = async (id) => {
    const res = await axios.delete(`/houses/remove/${id}`);
    getHouses();
    location.reload();
};

// portfolio funtionality

// const getPortfolio = async () => {
//     const res = await axios.get("/portfolio/");
//     const output = document.getElementById("houseCards")
//     output.innerHTML = "";
//     res.data.forEach(portfolio => renderPortfolio(portfolio));
// }

// const renderPortfolio = ({ id, name, occupancy, salePrice, rent }) => {
//     const column1 = document.createElement("div");
//     column1.className = "col";

//     const card1 = document.createElement("div");
//     card1.className = "card";
//     column1.appendChild(card);

//     const cardBody1 = document.createElement("div");
//     cardBody1.className = "card-body";
//     card1.appendChild(cardBody);

//     const pNameText = document.createElement("p");
//     pNameText.className = "card-text";
//     pNameText.innerText = `Name: ${name}`;
//     cardBody1.appendChild(pNameText);

//     const occupancyText = document.createElement("p");
//     occupancyText.className = "card-text";
//     occupancyText.innerText = `Occupancy: ${occupancy}`;
//     cardBody1.appendChild(occupancyText);

//     const salePriceText = document.createElement("p");
//     salePriceText.className = "card-text";
//     salePriceText.innerText = `Sale Price: ${salePrice}`;
//     cardBody1.appendChild(salePriceText);

//     const rentText = document.createElement("p");
//     rentText.className = "card-text";
//     rentText.innerText = `Rent Per Month: ${rent}`;
//     cardBody1.appendChild(rentText);

//     const cardFooter = document.createElement("div");
//     cardFooter.className = "card-footer";
//     card1.appendChild(cardFooter);

//     const deleteButton1 = document.createElement("a");
//     deleteButton1.innerText = "Delete";
//     deleteButton1.className = "card-link";
//     deleteButton1.addEventListener("click", function () {
//         deleteportfolio(id);
//     });
//     cardFooter1.appendChild(deleteButton1);

//     output.appendChild(column1);
// }

// getPortfolio();

// document.getElementById("createForm1").addEventListener("submit", function (event) {
//     event.preventDefault();

//     const data1 = {
//         name: this.name.value,
//         occupancy: this.occupancy.value,
//         salePrice: this.salePrice.value,
//         rent: this.rent.value
//     }

//     axios.post("/portfolio/create", data1)
//         .then(res => {
//             getPortfolio();
//             this.reset();
//             this.name.focus();
//         }).catch(err => console.log(err));

//     console.log(this);

//     axios.put("/portfolio/update", data)
//         .then(res => {
//             getPortfolio();
//             this.reset();
//             this.name.focus();
//         }).catch(err => console.log(err));

//     console.log(this);
// });

// const deletePortfolio = async (id) => {
//     const res = await axios.delete(`/portfolio/remove/${id}`);
//     getPortfolio();
//     location.reload();
// };