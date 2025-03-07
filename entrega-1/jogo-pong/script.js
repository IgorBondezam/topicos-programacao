let posicaoXBola = 300
let posicaoYBola = 200

let velocidadeXBola = 4
let velocidadeYBola = 4

let raio = 30

let player1X = 36
let player1Y = 150

let player2X = 556
let player2Y = 150

let pontosPlayer1 = 0
let pontosPlayer2 = 0

let largura = 15
let tamanho = 90

let velocidadeRaquete = 20

document.addEventListener('keypress', (value) => {
    if(value.key === 'w' && player1Y > 0) {
        player1Y -= velocidadeRaquete
        restartGame()
    }
    if(value.key === 's' && player1Y+tamanho < 400) {
        player1Y += velocidadeRaquete
        restartGame()
    }
})

document.addEventListener('keydown', (value) => {
    if(value.key === 'ArrowUp' && player2Y > 0) {
        player2Y -= velocidadeRaquete
        restartGame()
    }
    if(value.key === 'ArrowDown' && player2Y+tamanho < 400) {
        player2Y += velocidadeRaquete
        restartGame()
    }
})

function setup() {
    createCanvas(600, 400);
}

function draw() {
    background(0);

    createRect(player1X, player1Y, largura, tamanho)
    createRect(player2X, player2Y, largura, tamanho)

    incluiPlacar()

    pontos()
    createBall()
    moveBall()
}

function createBall() {
    circle(posicaoXBola, posicaoYBola, raio)
}

function createRect(posicaoX, posicaoY, largura, altura) {
    rect(posicaoX, posicaoY, largura, altura)
}

function moveBall() {

    posicaoXBola += velocidadeXBola
    posicaoYBola += velocidadeYBola

    let isBallInPlayer1 = (((player1Y + tamanho) >= posicaoYBola) && (player1Y <= posicaoYBola)) && posicaoXBola <= (player1X + largura) && posicaoXBola >= (player1X)
    let isBallInPlayer2 = (((player2Y + tamanho) >= posicaoYBola) && (player2Y <= posicaoYBola)) && posicaoXBola <= (player2X + largura) && posicaoXBola >= (player2X)

    if(isBallInPlayer1 || isBallInPlayer2) {
        if(!!parseInt(getRandomArbitrary(0,2))) {
            velocidadeYBola *= -1
        }
        velocidadeXBola *= -1
    }

    if(posicaoXBola >= 600 || posicaoXBola <= 0) {
        velocidadeXBola *= -1
    }
    if(posicaoYBola >= 400 || posicaoYBola <= 0) {
        velocidadeYBola *= -1
    }
}

function pontos() {
    if(posicaoXBola >= 590) {
        pontosPlayer1++
        resetarBola()
        resetarRaquete()
    }

    if(posicaoXBola <= 10) {
        pontosPlayer2++
        resetarBola()
        resetarRaquete()
    }
}

function resetarBola() {
    velocidadeXBola = 0
    velocidadeYBola = 0
    posicaoXBola = 300
    posicaoYBola = 200
}

function resetarRaquete() {
    player1Y=150
    player2Y=150
}


function restartGame() {
    if(velocidadeXBola === 0 || velocidadeYBola === 0) {
        velocidadeXBola = 4
        velocidadeYBola = 4
    }
}

function incluiPlacar() {
    fill(255);
    text(pontosPlayer1, 278, 26);
    text(pontosPlayer2, 321, 26);
}

function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
}