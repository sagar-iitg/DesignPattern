  function sendData() {
            const operand1 = parseFloat(document.getElementById('operand1').value);
            const operand2 = parseFloat(document.getElementById('operand2').value);
            const operation = document.getElementById('operation').value;
            const resultElement = document.getElementById('result');

            const data = {
                operand1: operand1,
                operand2: operand2,
                type: operation
            };

            fetch('performCalculation', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            })
                .then(response => response.json())
                .then(result => {
                    resultElement.textContent = result;
                })
                .catch(error => {
                    console.error('Error sending data to server:', error);
                });
        }

        function updateHistory() {
            fetch('history')
                .then(response => response.json())
                .then(data => {
                    const historyList = document.getElementById('operation-history');
                    historyList.innerHTML = '';

                    data.forEach(operation => {
                        const listItem = document.createElement('li');
                        listItem.textContent = `${operation.operand1} ${operation.operation} ${operation.operand2} = ${operation.result}`;
                        historyList.appendChild(listItem);
                    });
                })
                .catch(error => {
                    console.error('Error fetching history:', error);
                });
        }


        function showHistory() {
        	updateHistory();
            const historyDiv = document.getElementById('history');
            const historyButton = document.querySelector('#history button');
            const historyList = document.getElementById('operation-history');

            // Toggle the visibility of the history section
            if (historyList.style.display === 'none' || historyList.style.display === '') {
                historyList.style.display = 'block';
                historyButton.textContent = 'Hide History';
                updateHistory();
            } else {
                historyList.style.display = 'none';
                historyButton.textContent = 'Show History';
            }
        }

        // Initially hide the history section
        const historyList = document.getElementById('operation-history');
        historyList.style.display = 'none';