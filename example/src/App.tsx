import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { enableViewSecuring } from 'react-native-born-app-protect';

export default function App() {
  React.useEffect(() => {
    enableViewSecuring(true);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
