'use strict';
app.service('dialogModal', [
                            '$modal', function($modal) {
                            return function(message, title, okButton, cancelButton) {

                              okButton = okButton === false ? false : (okButton || 'Yes');
                              cancelButton = cancelButton === false ? false : (cancelButton || 'No');

                              var modalInstance = $modal.open({        
                                templateUrl: '/templates/deletePrompt.html',
                                controller: ModalInstanceCtrl,
                                resolve: {
                                  settings: function() {
                                    return {
                                      modalTitle: title,
                                      modalBody: message,
                                      okButton: okButton,
                                      cancelButton: cancelButton
                                    };
                                  }
                                }
                              });
                              // return the modal instance
                              return modalInstance;
                            }
                          }
                        ]);