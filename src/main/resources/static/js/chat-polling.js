let lastId = 0;

async function loadNewMessages() {
    const res = await fetch(`/api/chat?lastId=${lastId}`);
    const data = await res.json();

    const box = document.getElementById("chat-box");

    data.forEach(chat => {
        lastId = chat.id;
        const li = document.createElement("li");
        li.innerHTML = `<b>${chat.sender}</b>: ${chat.message}`;
        box.appendChild(li);
    });
}

async function sendMessage() {
    const sender = document.getElementById("sender").value;
    const message = document.getElementById("message").value;

    await fetch("/api/chat", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ sender, message })
    });

    document.getElementById("message").value = "";
}

// 처음 1번 전체 불러오기
loadNewMessages();

// 이후 2초마다 신규 메시지 poll
setInterval(loadNewMessages, 2000);